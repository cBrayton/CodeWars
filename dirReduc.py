def dirReduc(arr):
    '''
    Remove the redundant directions in an array of cardinal directions
    i.e. any adjacent North-South or East-West directions are removed 
    '''
    pairs = {"NORTH": "SOUTH", "SOUTH": "NORTH", "EAST": "WEST", "WEST": "EAST"}
    answer = arr
    update = True
    while(update == True):
        update = False
        idx = 0
        while(idx < len(answer)-1):
            if(answer[idx] == pairs[answer[idx+1]]):
                answer = answer[:idx] + answer[idx+2:]
                update = True
            idx += 1
    return answer