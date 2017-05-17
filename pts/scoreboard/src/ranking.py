from .group import Group


class Ranking:
    def __init__(self):
        self.teams = []

    def register_team(self, team):
        """Register a team in ranking board"""
        self.teams.append(team)

    def get_first_n(self, num=5):
        """Return first `num` best teams"""
        return sorted(self.teams, key=lambda t: t.points, reverse=True)[:num]

    def build_groups(self):
        """Return the list of groups containing teams"""
        # For simplicity groups contain 4 teams and number of teams is
        # divisible by 4
        groups = []
        for i in range(len(self.teams) // 4):
            groups.append(Group(chr(65 + i), teams=self.teams[i*4:(i+1)*4]))

        return groups
