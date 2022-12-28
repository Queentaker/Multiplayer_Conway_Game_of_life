### Softcon_Assignment-3
here is a list of what needs to be done apart from testing
##### make sure you write scalable code 

- Make sure to look at crc cards for further information and to see what needs to be implemented 😁

## Grid
- [x] stats whenever evolved stats need to change and when player adds and removes gridcells: observer necessary
- [x] the stats need to keep track of how many cells each player has and in which generation we are
- [x] create 4-6 template patterns that are legal
- [ ] make grid and templates work together
- [ ] not necessary create grititerator that returns list of neighbors
- [x] if done so change grid to be flexibale to recantangle
- [x] nextgen needs to count the cells when evolving
- [ ] GridButton JButton self implement to show color on Mac

## Gameflow

- [x] create setup that checks input and then creates the players and the grid with wished size
- [ ] in order to do that make grid 
- [x] turnflow meaning switch turn after player has removed and then added cell
- [x] make gamemanger singleton
- [x] manage players turn
- [ ] have turn ask player which cells he wants to remove and then add
- [x] not much has been implemented of gamemanger look at crc card is in whatsapp chat
- [x] turn should be able to give the name of the current player
- [x] make the desion choice if setup passes its information to the gamemanger or the gamemanger has an instance of setup.
- [x] add Frame as Observer

### Player
- [ ] human player get input from gui and pass it 
- [ ] abstract player has place and delete cell function, human player implements these



  
