/**
 * . solution class
 *
 * @author raviteja
 */
class Solution {
	/**
	 * . sorts the teams
	 *
	 * @param teams array of teams
	 * @return array of teams sorted
	 */
	public Team[] sort(final Team[] teams) {
		// your code goes here
		InsertionSort.sort(teams);
		return teams;
	}
}

/**
 * . team class implements comparable interface
 */
class Team implements Comparable<Team> {
	/**
	 * . name of team
	 */
	String teamName;
	/**
	 * . number of wins
	 */
	int noOfWins;
	/**
	 * . number of losses
	 */
	int noOfLosses;
	/**
	 * . number of draws
	 */
	int noOfDraws;

	/**
	 * . parametrised constructor
	 *
	 * @param name   name of team
	 * @param wins   no of wins
	 * @param losses no of losses
	 * @param draws  no of draws
	 */
	Team(final String name, final int wins, final int losses, final int draws) {
		teamName = name;
		noOfDraws = draws;
		noOfWins = wins;
		noOfLosses = losses;
	}

	/**
	 * . compareTo method compares the two objects based on wins, losses, draws
	 *
	 * @param that team object
	 * @return -1 if less than, 0 if equal, 1 if greater
	 */
	public int compareTo(final Team that) {
		if (this.noOfWins - that.noOfWins < 0) {
			return -1;
		} else if (this.noOfWins == that.noOfWins) {
			if (this.noOfLosses - that.noOfLosses > 0) {
				return -1;
			} else if (this.noOfLosses == that.noOfLosses) {
				if (this.noOfDraws - that.noOfDraws < 0) {
					return -1;
				} else if (this.noOfDraws == that.noOfDraws) {
					return 0;
				}
			}
		}
		return 1;
	}

	/**
	 * . toString method returns the details of a team
	 *
	 * @return string format of teams
	 */
	public String toString() {
		return this.teamName + ", " + this.noOfDraws + ", " + this.noOfLosses + ", " + this.noOfWins;
	}
}
