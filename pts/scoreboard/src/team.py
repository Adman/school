class Team:
    ID = 0

    def __init__(self, name, points):
        self.id = Team.ID
        Team.ID += 1
        self.name = name
        self.points = points

    def __repr__(self):
        return 'ID{0} - Team {1} - {2}'.format(self.id, self.name, self.points)
