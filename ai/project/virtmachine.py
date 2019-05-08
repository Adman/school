import consts

OUTPUTS = {
    0: 'H',
    1: 'H',
    2: 'H',
    3: 'D',
    4: 'D',
    5: 'P',
    6: 'P',
    7: 'L',
    8: 'L'
}

MOVES = {
    'H': (0, -1),
    'D': (0,  1),
    'P': (1,  0),
    'L': (-1, 0)
}


class VirtualMachine:
    def __init__(self, world):
        self.world = world
        self.program = None

    def _stop_program(self):
        if self.gold_found == self.world.golds:
            return True
        if not self._within_bounds():
            return True
        if self.steps >= consts.MAX_PROGRAM_STEPS:
            return True
        return False

    def _within_bounds(self):
        return (0 <= self.x < self.world.width) and \
                (0 <= self.y < self.world.height)

    def _move_hunter(self, move):
        change = MOVES[move]
        self.x += change[0]
        self.y += change[1]

        if self._within_bounds():
            if self.grid[self.y][self.x] == 'G':
                self.gold_found += 1
                self.grid[self.y][self.x] = '#'

    def run_program(self, program):
        # initialization
        self.program = program
        self.grid = list(map(list, self.world.grid))
        self.gold_found = 0
        self.x = self.world.startx
        self.y = self.world.starty
        self.steps = 0

        output = []
        addr = 0  # starting address
        prog = self.program.instructions.copy()

        while not self._stop_program():
            value = prog[addr]
            inst = value >> 6
            address = value & 0b00111111

            if inst == consts.INST_INCREMENT:
                prog[address] = (prog[address] + 1) % 256
                addr = (addr + 1) % 64
            elif inst == consts.INST_DECREMENT:
                if prog[address] == 0:
                    prog[address] = 255
                else:
                    prog[address] -= 1
                addr = (addr + 1) % 64
            elif inst == consts.INST_JUMP:
                addr = address
            elif inst == consts.INST_OUTPUT:
                ones = bin(value).count('1')
                move = OUTPUTS[ones]
                self._move_hunter(move)
                output.append(move)
                addr = (addr + 1) % 64

            self.steps += 1

        self.program.gold_found = self.gold_found
        self.program.out = not self._within_bounds()
        self.program.steps = self.steps
        self.program.output = output
        self.program.compute_fitness()
