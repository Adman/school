from src.simulator import Simulator
from src.team import Team
from src.ranking import Ranking


if __name__ == '__main__':
    ranking = Ranking()

    setup_teams = ['Slovakia', 'Brasil', 'Argentina', 'Germany', 'France',
                   'Spain', 'England', 'Italy']

    print('Registering teams into ranking...')
    for t in setup_teams:
        ranking.register_team(Team(t, 0))

    print('Building groups...')
    groups = ranking.build_groups()
    for group in groups:
        group.generate_matches()

    print('Building simulator...')
    sim = Simulator(groups)

    print('Simulating qualification...')
    while not sim.simulate_qualification_one_day():
        pass

    print('Building championship...')
    sim.build_championship()

    print('Simulating championship spider rounds...')
    while not sim.simulate_championship_round():
        pass

    print('Done... The winner is {0}'.format(sim.get_championship_winner()))
