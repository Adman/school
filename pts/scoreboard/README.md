scoreBoard
==========

A simple scoreboard which should simulate qualification and the tournament.

Design
------

* **Team** - class for encapsulating a single team along with its ranking score
* **Group** - class for holding multiple teams and generating matches for them -
also keeps track of points
* **Match** - class for holding the match between 2 teams as well as schedule and results
* **Ranking** - team ranking table which is responsible for sorting teams according to their rank points
* **Simulator**
    - Simulates tournament qualification
    - Simulates tournament


The Qualification process holds groups, each one with 4 teams. Two best teams
from each group advance to Championship. The results of matches are generated
randomly. The team that wins the match is rewarded +1 point and the other one' rank
is decreased by 1 point.

The Championship is built using spider style. Each SpiderRound is kept for showing historical results.
The winners of current SpiderRound advance to next one.
