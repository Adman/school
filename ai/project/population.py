import random
import numpy as np

import consts
from program import Program


class Population:
    def __init__(self, popul=None):
        self.popul = popul if popul is not None else []

    def generate_random(self):
        self.popul = [Program(random=True) for _ in range(consts.POPULATION_N)]

    def run_individuals(self, vm):
        for p in self.popul:
            vm.run_program(p)

    def sort_by_fitness(self):
        self.popul = sorted(self.popul, key=lambda p: p.fitness, reverse=True)

    def get_best_individual(self):
        """This method assumes that we have already called sort_by_fitness"""
        return self.popul[0]

    def crossover(self, parent1, parent2):
        """One point crossover"""
        index = random.randint(1, 62)
        insts = parent1.instructions[:index] + parent2.instructions[index:]
        return Program(instructions=insts)

    def _best_random_parent(self, popul):
            rands = random.sample(popul, consts.TOURNAMENT_N)
            parent = sorted(rands, key=lambda p: p.fitness, reverse=True)[0]
            return parent, self.popul.index(parent)

    def get_new_population(self, selection):
        if selection == consts.SELECTION_TOURNAMENT:
            parent1, index = self._best_random_parent(self.popul)
            parent2, _ = self._best_random_parent(self.popul[:index] +
                                                  self.popul[index+1:])
        elif selection == consts.SELECTION_ROULETTE:
            fitsum = sum([p.fitness for p in self.popul])
            probs = [p.fitness / fitsum for p in self.popul]
            parent1, parent2 = np.random.choice(self.popul,
                                                2,
                                                replace=False,
                                                p=probs)

        children = consts.POPULATION_N - (consts.ELITARISM*consts.ELITARISM_N)
        new_popul = [self.crossover(parent1, parent2)
                     for i in range(children)]
        for p in new_popul:
            p.mutate()

        if consts.ELITARISM:
            new_popul += self.popul[:consts.ELITARISM_N]

        return Population(popul=new_popul)
