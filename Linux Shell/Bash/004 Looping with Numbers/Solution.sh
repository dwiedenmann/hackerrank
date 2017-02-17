#!/bin/sh
########################################################################################################################
#			  __               __                              __
#		   / /_  ____ ______/ /_____  ______________ _____  / /__
#		  / __ \/ __ `/ ___/ //_/ _ \/ ___/ ___/ __ `/ __ \/ //_/
#		 / / / / /_/ / /__/ ,< /  __/ /  / /  / /_/ / / / / ,<
#		/_/ /_/\__,_/\___/_/|_|\___/_/  /_/   \__,_/_/ /_/_/|_|
#
########################################################################################################################
###	Linux Shell ########################################################################################################
########################################################################################################################
#
#		https://www.hackerrank.com/challenges/bash-tutorials---looping-with-numbers
#
# 	Looping with Numbers
#
#   for loops in Bash can be used in several ways:
#   - iterating between two integers, a and b
#   - iterating between two integers, a and b, and incrementing by c each time
#   - iterating through the elements of an array, etc.
#
#   Use for loops to display the natural numbers from 1 to 50.
#
#   Input
#   There is no input
#
#   Output
#
#   1
#   2
#   3
#   4
#   5
#   .
#   .
#   .
#   .
#   .
#   50
#   Recommended Resources
#   A quick but useful tutorial for Bash newcomers is here.
#     (http://www.panix.com/~elflord/unix/bash-tute.html)
#   Handling input is documented and explained quite well on this page.
#     (http://tldp.org/LDP/Bash-Beginners-Guide/html/sect_08_02.html)
#   Different ways in which for loops may be used are explained with examples here.
#     (http://www.cyberciti.biz/faq/bash-for-loop/)
#
#
########################################################################################################################

# Use seq
#seq 50

# bash
# is bash 4.0+ can use {a..b..c} to increment by more than 1
for i in {1..50}
do
  echo $i
done
