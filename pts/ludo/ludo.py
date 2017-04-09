import random

FIELDS = 50
MAX_POINTS = 20


class Player:
    """Storing player's pieces positions"""
    def __init__(self, pieces=(0, 0, 0, 0), points=0):
        self.pieces = pieces
        self.points = points


class Ludo:
    """Class for storing the game state"""
    def __init__(self, players=(), turn=0):
        self.players = players
        self.turn = turn

    def print_turn(self):
        print('Player {0} is on turn.'.format(self.turn))

    def print_points(self):
        """Print players along with their points"""
        for i, p in enumerate(self.players):
            print('Player {0}: {1} points'.format(i, p.points))

    def print_standings(self):
        """Print standings of player's pieces"""
        for i, p in enumerate(self.players):
            msg = 'Player {0}\'s pieces are on fields: 0:{1} 1:{2} 2:{3}' \
                  ' 3:{4} -- {5} points'
            print(msg.format(i, p.pieces[0], p.pieces[1], p.pieces[2],
                             p.pieces[3], p.points))

    def move(self, piece=0, num=0):
        """Take player which is on turn and move their piece by given
        dice. If player passes, just copy the state and return it"""
        players = []
        status = False
        for i, p in enumerate(self.players):
            pieces = [p.pieces[0], p.pieces[1], p.pieces[2], p.pieces[3]]
            points = p.points
            if i == self.turn:
                if pieces[piece] + num >= FIELDS:
                    points += 1
                    if points == MAX_POINTS:
                        status = True
                pieces[piece] = (pieces[piece] + num) % FIELDS

            players.append(Player(pieces=tuple(pieces), points=points))

        new = Ludo(players=tuple(players), turn=(self.turn+1) % 4)
        return (new, status)


if __name__ == '__main__':
    players = []
    for i in range(4):
        pieces = [random.randint(0, FIELDS-1), random.randint(0, FIELDS-1),
                  random.randint(0, FIELDS-1), random.randint(0, FIELDS-1)]
        players.append(Player(pieces=pieces))
    ludo = Ludo(players=tuple(players))

    dice = 0
    status = False
    while True:
        inp = input('>> ').split(' ')

        cmd = inp[0]
        if cmd == 'throw':
            ludo.print_turn()
            dice = random.randint(1, 6)
            print('Dice: {0}'.format(dice))
            ludo.print_standings()
        elif cmd == 'pass':
            ludo, status = ludo.move()
        elif cmd == 'move' and inp[1]:
            ludo, status = ludo.move(int(inp[1]), dice)
        elif cmd == 'points':
            ludo.print_points()
        elif cmd == 'exit':
            print('Quit...')
            break

        if status:
            print('End of the game')
            ludo.print_points()
            break
