Barrel_Race_Game
================

This game uses the accelerometer, a sensor found on most Android devices.  You can also use the gravimeter.  A barrel race is a rodeo event in which the rider starts at a gate and must ride completely around three (sometimes four) barrels.  That is, he or she must circle each of the barrels.  The object is to get the fastest time without knocking over any of the barrels.  In the game you will write, your “horse” starts out at the gate, and you must maneuver him around the three barrels, as shown in the diagram, and back through the gate. You do this by tilting your device one way or another.  The course should be square and at the bottom of your screen, leaving room for a start button (not shown) and the time.  Touching any of the barrels means you lose, and must start over.  Hitting the fences around the course will add 5 seconds to your time, but you get to continue the race.  Your screen should look something like the graphic shown below:  The circles in the center arranged in a triangle are the barrels.  The black circle at the bottom is your horse at the starting gate, and the time is shown as minutes, seconds, and hundredths.  The timer starts when you press the start button and ends when your horse is entirely through the gate.   You could also start the game by touching the horse.
Obviously there is considerable calculation in this program.  You’ll need to compute the position of the horse based upon accelerometer readings.  You’ll need to determine whether the horse has circled a given barrel, or touched it.  You’ll need to adapt the program to different screen sizes and resolutions.
It’s not a game unless someone can lose.  Therefore, keep track of the 10 fastest times along with the name of the player.  When a game ends, check the time against the current list of fastest times and, if it is faster than the slowest time, drop off the slowest time and insert the new time in the proper place in the list, along with the name the winner enters.  Provide a way in the action bar to view high scores.  Thus you will have to keep a file of scores.
Consider as you write this how to make the app configurable.  Some possible things are color, size of the barrels, etc.  Consider also how the app can get to know the user.
The app should pause when its screen is no longer active and resume when it is, after a five-second delay.
Note: the graphic shown below is only a sketch of how the app could look.  You are not required nor expected to reproduce this graphic exactly.  For example, you could use an actual graphic of a horse rather than a circle.  Creativity and imagination are good as long as you meet the basic requirements.
