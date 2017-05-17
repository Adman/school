import datetime

from .utils import round_robin
from .match import Match


class Group:
    ID = 0

    def __init__(self, name, teams=[], matches=[]):
        self.id = Group.ID
        Group.ID += 1
        self.name = name
        self.teams = teams
        self.matches = matches
        self.played = False

        self.curr_date = datetime.datetime(2015, 1, 1, 23, 0)

        self.points = {}
        for team in self.teams:
            self.points[team] = 0

    def add_team(self, team):
        """Register new team into group"""
        self.teams.append(team)

    def generate_matches(self, start_date=None):
        """Generate matches using round robin"""
        schedule = round_robin(self.teams)

        if start_date is None:
            start_date = datetime.datetime(2015, 1, 1, 10, 0)

        for x in schedule:
            for match in x:
                self.matches.append(Match(match[0], match[1], start_date))
            start_date += datetime.timedelta(days=1)

    def play_match(self, match):
        """Play a single match assigned to the group"""
        match.play()

    def play_all_matches(self):
        """Play all the matches assigned to the group"""
        for match in self.matches:
            self.play_match(match)
        self.played = True

    def play_next_day(self):
        """Play matches scheduled to current date"""
        done = True
        for match in self.matches:
            if match.scheduled <= self.curr_date and not match.played:
                match.play()
            elif not match.played:
                done = False

        self.curr_date += datetime.timedelta(days=1)
        return done

    def get_first_teams(self, n=2):
        """Get first `n` teams"""
        return [t for t in sorted(self.points, key=self.points.get,
                                  reverse=True)][:n]
