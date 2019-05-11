import matplotlib.pyplot as plt

import consts
from population import Population
from virtmachine import VirtualMachine


class World:
    def __init__(self, m):
        with open(m, 'r') as f:
            self.height, self.width = map(int, f.readline().split(' '))
            self.golds = int(f.readline())
            self.grid = []
            for i, line in enumerate(f):
                if 'S' in line:
                    self.startx = line.find('S')
                    self.starty = i
                    line = line.replace('S', '#')
                self.grid.append(list(line.replace('\n', '')))


def run_algorithm(world, selection):
    vm = VirtualMachine(world)

    popul = Population()
    popul.generate_random()

    best_ind = None
    solution_found = False

    fitnesses = []

    for i in range(consts.MAX_GENERATIONS):
        popul.run_individuals(vm)
        popul.sort_by_fitness()

        best_popul_ind = popul.get_best_individual()
        best_popul_fitness = best_popul_ind.fitness
        best_popul_gold_found = best_popul_ind.gold_found

        fitnesses.append(best_popul_fitness)

        text = 'Generation: {}, crossover: {}, best fitness: {}, golds: {}/{}'
        print(text.format(i, selection, best_popul_fitness,
                          best_popul_gold_found, world.golds))

        if best_popul_gold_found == world.golds:
            print('Solution found: ', best_popul_ind.output)
            solution_found = True
            break

        if best_ind is None or best_ind.gold_found < best_popul_gold_found:
            best_ind = best_popul_ind

        # generate new population
        popul = popul.get_new_population(selection)

    if not solution_found:
        text = 'Best solution with {} golds:'.format(best_ind.gold_found)
        print(text, best_ind.output)

    return fitnesses


if __name__ == '__main__':
    world = World('map.txt')

    fit_tournament = run_algorithm(world, consts.SELECTION_TOURNAMENT)
    fit_roulette = run_algorithm(world, consts.SELECTION_ROULETTE)

    plt.plot(list(range(min(consts.MAX_GENERATIONS, len(fit_tournament)))),
             fit_tournament, label='tournament')
    plt.plot(list(range(min(consts.MAX_GENERATIONS, len(fit_roulette)))),
             fit_roulette, label='roulette')
    plt.xlabel('Generation')
    plt.ylabel('Best fitness')
    plt.legend()
    plt.show()
