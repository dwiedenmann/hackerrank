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
#		https://www.hackerrank.com/challenges/bash-tutorials---a-personalized-echo
#
# 	A Personalized Echo
#
#   Write a Bash script which accepts  as input and displays a greeting: "Welcome (name)"
#
#   A Quick Introduction to 'Echo'
#
#   This is the equivalent of common output commands in most programming language (print or puts statements).
#
#   For Example:
#     echo "Greetings"
#
#   This outputs just one word "Greetings" (without the quotation marks).
#
#     echo "Greetings $USER, your current working directory is $PWD"
#
#   This picks up the values of the environment variables USER and PWD and displays something like:
#
#     Greetings prashantb1984, your current working directory is /home/prashantb1984
#     The above message, of course, will vary from system to system, depending on the setting of environment variables.
#
#   Accepting Inputs
#
#   This can be accomplished using the read statement.
#     read number
#     echo "The number you have entered is $number"
#
#   If the user provides an input 4, the output is:
#     The number you have entered is 4
#
#   Consider this snippet:
#     read name
#     echo "The name you have entered is $name"
#
#   If the user provides an input Max, the output is:
#     The name you have entered is Max
#
#
#   Recommended Resources
#     A quick but useful tutorial for Bash newcomers is here.
#       (http://www.panix.com/~elflord/unix/bash-tute.html)
#     Handling input is documented and explained quite well on this page.
#       (http://tldp.org/LDP/Bash-Beginners-Guide/html/sect_08_02.html)
#
#
#   Input Format
#     One line, containing a name.
#
#   Output Format
#     One line: "Welcome (name)" (quotation marks excluded).
#     The evaluation will be case-sensitive.
#
#   Sample Input 0
#     Dan
#
#   Sample Output 0
#     Welcome Dan
#
#   Sample Input 1
#     Prashant
#
#   Sample Output 1
#     Welcome Prashant
#
########################################################################################################################

read name

echo Welcome $name
