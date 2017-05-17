import random


class Match:
    def __init__(self, teama, teamb, scheduled):
        self.teama = teama
        self.teamb = teamb
        self.scheduled = scheduled
        self.played = False
        self.scorea = 0
        self.scoreb = 0

    def play(self):
        """Simulate playing this match"""
        self.played = True
        self.scorea = random.randint(0, 10)
        self.scoreb = random.randint(0, 10)

        if self.scorea != self.scoreb:
            if self.scorea > self.scoreb:
                self.teama.points += 1
                self.teamb.points -= 1
            else:
                self.teama.points -= 1
                self.teamb.points += 1

    def get_winner(self):
        """Return winner of the match - in case of draw, return random one"""
        if self.scorea > self.scoreb:
            return self.teama
        elif self.scorea < self.scoreb:
            return self.teamb

        x = random.randint(0, 1)
        return self.teama if x == 0 else self.teamb

    def __repr__(self):
        played = 'played' if self.played else 'not played yet'
        return '{0} - {1}:{3} - {2} ->'.format(self.teama.name, self.scorea,
                                               self.teamb.name, self.scoreb,
                                               played)
