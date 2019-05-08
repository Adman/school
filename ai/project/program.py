import random


class Program:
    def __init__(self, instructions=None, random=False):
        self.instructions = [] if instructions is None else instructions

        self.gold_found = 0
        self.out = False
        self.steps = 0
        self.output = []
        self.fitness = 0

        if random:
            self.generate_instructions()

    def generate_instructions(self):
        self.instructions = [random.randint(0, 255) for _ in range(16)]
        for _ in range(48):
            self.instructions.append(0)

    def mutate(self):
        for i in range(64):
            # 1% chance for mutation to occur at each address
            if random.random() < 0.01:
                mutation_id = random.randint(0, 1)

                # invert random bit
                if mutation_id == 0:
                    bit = random.randint(1, 7)
                    num = self.instructions[i] ^ (1 << bit)
                # increment instruction cell
                elif mutation_id == 1:
                    num = (self.instructions[i] + 1) % 256

                self.instructions[i] = num

    def compute_fitness(self):
        # add +1 so we will not get negative fitness
        self.fitness = 1 + self.gold_found -\
                       (self.steps*0.001) -\
                       (self.out*0.01)
