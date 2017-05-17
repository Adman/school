import datetime

from .match import Match


class Qualification:
    def __init__(self, groups=[]):
        self.groups = groups

    def play(self):
        for group in self.groups:
            group.play_all_matches()

    def play_one_day(self):
        done = True
        for group in self.groups:
            done = done and group.play_next_day()
        return done

    def get_qualified_teams(self):
        teams = []
        for group in self.groups:
            teams += group.get_first_teams()
        return teams


class SpiderRound:
    def __init__(self, teams, scheduled):
        self.teams = teams
        self.matches = []
        self.scheduled = scheduled

    def generate_matches(self):
        for i in range(0, len(self.teams), 2):
            self.matches.append(Match(self.teams[i], self.teams[i+1],
                                      self.scheduled))

    def play(self):
        for match in self.matches:
            match.play()

    def get_winners(self):
        return [match.get_winner() for match in self.matches]


class Championship:
    def __init__(self, teams):
        self.teams = teams
        self.scheduled = datetime.datetime(2018, 6, 14, 10, 0)
        self.spider = [SpiderRound(self.teams, self.scheduled)]
        self.finished = False

    def play_one_round(self):
        self.spider[-1].generate_matches()
        self.spider[-1].play()
        winners = self.spider[-1].get_winners()
        if len(winners) == 1:
            self.finished = True
            return True

        self.spider.append(SpiderRound(winners, self.scheduled))
        self.scheduled += datetime.timedelta(days=1)
        return False

    def get_winner(self):
        return self.spider[-1].get_winners()[0]


class Simulator:
    def __init__(self, groups=[]):
        self.quali = Qualification(groups)
        self.champ = None

    def simulate_championship_round(self):
        return self.champ.play_one_round()

    def simulate_qualification_one_day(self):
        return self.quali.play_one_day()

    def simulate_qualification(self):
        self.quali.play()

    def build_championship(self):
        self.champ = Championship(self.quali.get_qualified_teams())

    def get_championship_winner(self):
        return self.champ.get_winner()
