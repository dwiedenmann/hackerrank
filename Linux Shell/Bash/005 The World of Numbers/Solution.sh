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
#		https://www.hackerrank.com/challenges/bash-tutorials---the-world-of-numbers
#
# 	The World of Numbers
#
#   Given two integers, X and Y, find their sum, difference, product, and quotient.
#
#   Input Format
#     Two lines containing one integer each (X and Y, respectively).
#
#   Input Constraints
#     100 <= X
#     Y <= 100
#     Y != 0
#
#   Output Format
#     Four lines containing the sum (X+Y), difference (X-Y), product (X*Y), and quotient (X/Y), respectively.
#     (While computing the quotient, print only the integer part.)
#
#   Sample Input
#     5
#     2
#
#   Sample Output
#     7
#     3
#     10
#     2
#
#   Reference Resources
#     A relevant and interesting discussion on Stack-Exchange for those getting started with handling numbers and arithmetic operations in Bash.
#       (http://unix.stackexchange.com/questions/93029/how-can-i-add-subtract-etc-two-numbers-with-bash)
#
#
########################################################################################################################

# X+Y
# X-Y
# X*Y
# X/Y
ops=("+" "-" "*" "/")

# Read input
read X
read Y
#X=5
#Y=2

# Loop through operations
for op in "${ops[@]}"; do
  # perform numeric calculation
  echo $(($X$op$Y))
done
