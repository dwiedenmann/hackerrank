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
#		https://www.hackerrank.com/challenges/bash-tutorials---looping-and-skipping
#
# 	Looping and Skipping
#
#   for loops in Bash can be used in several ways:
#   - iterating between two integers, a and b
#   - iterating between two integers, a and b, and incrementing by c each time
#   - iterating through the elements of an array, etc.
#
#   Your task is to use for loops to display only odd natural numbers from 1 to 99.
#
#   Input
#   There is no input.
#
#   Output
#
#     1
#     3
#     5
#     .
#     .
#     .
#     .
#     .
#     99
#
#   Recommended Resources
#
#   A quick but useful tutorial for bash newcomers is here.
#     (http://www.panix.com/~elflord/unix/bash-tute.html)
#   Handling input is documented and explained quite well on this page.
#     (http://tldp.org/LDP/Bash-Beginners-Guide/html/sect_08_02.html)
#   Different ways in which for loops may be used are explained with examples here.
#     (http://www.cyberciti.biz/faq/bash-for-loop/)
#
#
########################################################################################################################

for i in `seq 1 99`;
do
  if [ `expr $i % 2` -eq 1 ]; then
    echo $i
  fi
done
