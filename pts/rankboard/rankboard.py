import getpass
import sys
import hashlib

PASSWORD = None


def get_hash(string):
    """Return hexdigest of hashed string using sha256"""
    return hashlib.sha256(string.encode()).hexdigest()


def password_required(method):
    """Decorator for promting user for password before entering the method"""
    def wrapper(*args, **kwargs):
        try:
            while get_hash(getpass.getpass('Enter password: ')) != PASSWORD:
                print('Wrong password! Try again...')
        except KeyboardInterrupt:
            print()
            return
        method(*args, **kwargs)
    return wrapper


class Player:
    STANDARD_PLAYER = 0
    JUNIOR_PLAYER = 1

    def __init__(self, name, points):
        self.name = name
        self.points = points
        self.type = self.STANDARD_PLAYER

    def add_points(self, number):
        self.points += number

    def decrease_points(self, number):
        self.points -= number

    def set_junior(self):
        self.type = self.JUNIOR_PLAYER


class RankBoard:
    def __init__(self):
        self.players = []

    def process_cmd(self, cmd, args):
        """Call specific method from dictionary according to cmd"""
        methods = {'points': self.points, 'reduce': self.reduce,
                   'junior': self.junior, 'ranking': self.ranking,
                   'ranking_junior': self.ranking_junior, 'quit': self.quit}

        if cmd == 'ranking' and args and args[0] == 'junior':
            methods['ranking_junior']()
        else:
            try:
                methods[cmd](*args)
            except KeyError:
                print('No such command found!')
            except TypeError:
                print('Wrong number of arguments!')
            except ValueError:
                print('Wrong type of arguments!')

    @password_required
    def points(self, name, number):
        """Create player with number points or add them to existing one"""
        number = int(number)
        filtered = list(filter(lambda p: p.name == name, self.players))
        if filtered:
            filtered[0].add_points(number)
        else:
            self.players.append(Player(name, number))

    @password_required
    def reduce(self, percents):
        """Reduce each player's points by given number of percents"""
        for p in self.players:
            p.decrease_points(int((int(percents)/100)*p.points))

    @password_required
    def junior(self, name):
        """Mark player with <name> as a junior player"""
        for p in self.players:
            if p.name == name:
                p.set_junior()

    def standings(self, players):
        """Print standings of given list of players descendingly"""
        sorted_players = sorted(players, key=lambda x: x.points, reverse=True)
        for i, p in enumerate(sorted_players, start=1):
            print('{0}. {1} - {2} points'.format(i, p.name, p.points))

    def ranking(self):
        """Standings across all the players"""
        self.standings(self.players)

    def ranking_junior(self):
        """Standings across junior players"""
        self.standings(list(filter(lambda p: p.type == Player.JUNIOR_PLAYER,
                                   self.players)))

    @password_required
    def quit(self):
        """Quit the program"""
        sys.exit(0)


if __name__ == '__main__':
    PASSWORD = get_hash(getpass.getpass('Set your password: '))

    rank_board = RankBoard()

    while True:
        msg = input('>> ').split(' ')
        rank_board.process_cmd(msg[0], msg[1:])
