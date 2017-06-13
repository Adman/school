import unittest
from ludo import Ludo, Player, FIELDS, MAX_POINTS


class LudoTest(unittest.TestCase):
    def get_ludo(self, players_pieces=[]):
        players = []
        if not players_pieces:
            players_pieces = [[1, 10, 20, 30],
                              [5, 15, 25, 35],
                              [2, 14, 11, 28],
                              [39, 41, 42, 43]]

        for i in range(4):
            players.append(Player(pieces=players_pieces[i]))
        return Ludo(players=tuple(players))

    def test_move(self):
        dice = 5
        l1 = self.get_ludo()
        l2, _ = l1.move(0, dice)

        self.assertEqual(l2.players[0].pieces[0], 6)
        self.assertEqual(l2.turn, 1)

        l3, _ = l2.move(1, dice)

        self.assertEqual(l3.players[1].pieces[1], 20)
        self.assertEqual(l3.turn, 2)

    def test_pass(self):
        l1 = self.get_ludo()
        l2, _ = l1.move(0, 0)

        self.assertEqual(l2.players[0].pieces[0], l1.players[0].pieces[0])
        self.assertEqual(l2.turn, 1)

    def test_scored(self):
        dice = 3
        l1 = self.get_ludo()
        l1.players[0].pieces[0] = FIELDS-1
        l2, _ = l1.move(0, dice)

        self.assertEqual(l2.players[0].points, 1)
        self.assertEqual(l2.players[0].pieces[0], 2)
        self.assertFalse(l2.players[0].points == l1.players[0].points)

    def test_finished(self):
        dice = 6
        l1 = self.get_ludo()
        l1.players[0].pieces[0] = FIELDS - 1
        l1.players[0].points = MAX_POINTS - 1
        l2, status = l1.move(0, dice)

        self.assertTrue(status)


if __name__ == '__main__':
    unittest.main()
