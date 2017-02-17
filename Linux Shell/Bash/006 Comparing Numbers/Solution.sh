#!/bin/sh
########################################################################################################################
#			  __               __                              __
#		   / /_  ____ ______/ /_____  ______________ _____  / /__
#		  / __ \/ __ `/ ___/ //_/ _ \/ ___/ ___/ __ `/ __ \/ //_/
#		 / / / / /_/ / /__/ ,< /  __/ /  / /  / /_/ / / / / ,<
#		/_/ /_/\__,_/\___/_/|_|\___/_/  /_/   \__,_/_/ /_/_/|_|
#
########################################################################################################################
### Linux Shell ########################################################################################################
########################################################################################################################
#
#		https://www.hackerrank.com/challenges/bash-tutorials---comparing-numbers
#
# 	Comparing Numbers
#
#   Given two integers, X and Y, identify whether X < Y or X > Y or X = Y.
#
#   Comparisons in a shell script may either be accomplished using regular operators (such as < or >)
#   or using (-lt, -gt, -eq, i.e. less than, greater than, equal to) for POSIX shells.
#   This discussion on stack overflow contains useful information on this topic.
#     (http://stackoverflow.com/questions/18668556/comparing-numbers-in-bash)
#
#   Input Format
#     Two lines containing one integer each (X and Y, respectively).
#
#   Output Format
#     Exactly one of the following lines:
#     - X is less than Y
#     - X is greater than Y
#     - X is equal to Y
#
#   Sample Input 1
#     5
#     2
#
#   Sample Output 1
#     X is greater than Y
#
#   Sample Input 2
#     2
#     2
#
#   Sample Output 2
#     X is equal to Y
#
#   Sample Input 3
#     2
#     3
#
#   Sample Output 3
#     X is less than Y
#
#     Reference Resources
#       A relevant and interesting discussion on Stack-Exchange for those getting started with handling numbers and arithmetic operations in Bash.
#         (http://unix.stackexchange.com/questions/93029/how-can-i-add-subtract-etc-two-numbers-with-bash)
#       These discussions on stack overflow and geeksforgeeks contains useful information on this topic.
#         (http://stackoverflow.com/questions/18668556/comparing-numbers-in-bash)
#         (http://www.thegeekstuff.com/2010/06/bash-conditional-expression/)
#
#
########################################################################################################################

# Read input
read X
read Y
#X=5
#Y=5

if [ $X -gt $Y ]; then
  echo "X is greater than Y"
elif [ $X -lt $Y ]; then
  echo "X is less than Y"
else
  echo "X is equal to Y"
fi
