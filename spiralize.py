def spiralize(size):
    '''
    Creates an array of arrays of the given size that represents a spiral starting
    at the top left corner, using 1's to mark out the spiral and 0's for the background 
    '''
    if(size == 0): return []
    spiral = [0]*size
    for x in range(size):
        spiral[x] = [0]*size
    run_size = size
    location = [0,0,0]
    while run_size >= 2 and size > 3:
        for x in range(run_size):
            if location[2] == 0:
                spiral[location[0]][location[1]+x] = 1
            elif location[2] == 1:
                spiral[location[0]+x][location[1]] = 1
            elif location[2] == 2:
                spiral[location[0]][location[1]-x] = 1
            elif location[2] == 3:
                spiral[location[0]-x][location[1]] = 1
        if location[2] == 0:
            location[1] = location[1] + x
            location[2] = 1
            if(location[0] != 0): run_size = run_size-2
        elif location[2] == 1:
            location[0] = location[0] + x
            location[2] = 2
            if(run_size == 2): run_size = run_size-1
        elif location[2] == 2:
            location[1] = location[1] - x
            location[2] = 3
            run_size = run_size-2
        elif location[2] == 3:
            location[0] = location[0] -x
            location[2] = 0
            if(run_size == 2): run_size = run_size-1
    if(size <= 3):
        spiral[0] = [1]*size # Set top row of special cases
        if(size == 3): spiral[size-1] = [1]*size # Set bottom row of special cases
        for y in range(1,size):
            spiral[y][size-1] = 1 # Set right side of special cases
    return spiral