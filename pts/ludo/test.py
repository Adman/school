import unittest
import random
from ludo import Ludo, Player, FIELDS


class LudoTest(unittest.TestCase):
    def get_ludo(self):
        players = []
        for i in range(4):
            pieces = [random.randint(0, FIELDS), random.randint(0, FIELDS),
                      random.randint(0, FIELDS), random.randint(0, FIELDS)]
            players.append(Player(pieces=pieces))
        return Ludo(players=players)

    def test_move(self):
        dice = random.randint(1, 6)
        l1 = self.get_ludo()
        l2, _ = l1.move(0, dice)

        self.assertEqual(l2.players[0].pieces[0],
                         (l1.players[0].pieces[0] + dice) % FIELDS)
        self.assertEqual(l1.turn, l2.turn - 1)

        l3, _ = l2.move(1, dice)

        self.assertEqual(l3.players[1].pieces[1],
                         (l2.players[1].pieces[1] + dice) % FIELDS)
        self.assertEqual(l2.turn, l3.turn - 1)

    def test_pass(self):
        l1 = self.get_ludo()
        l2, _ = l1.move(0, 0)

        self.assertEqual(l2.players[0].pieces[0], l1.players[0].pieces[0])
        self.assertEqual(l1.turn, l2.turn - 1)


if __name__ == '__main__':
    unittest.main()
