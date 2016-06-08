def total_inc_dec(x):
    '''Determines the total increasing or decreasing numbers up to (but not including) a power of 10.
    Takes a power of ten, x, and returns a long indicating how many increasing or decreasing numbers
    are less than 10^x.
    (Examples of increasing and decreasing numbers: 123, 112, 521, 75331, 12344566, etc.)
    '''
    sum = 0
    for digit in xrange(x+1):
        if digit == 0:
            sum += 1
        if digit == 1 or digit == 2:
            sum += 9*pow(10,digit-1)
        if digit >= 3:
            for i in xrange(10): 
            # Calculate sum of ith row of values in a 10x10 matrix
            # The matrix is organized where columns represent the more significant digit and rows the less significant.
            # e.g. column 2 row 5 represents the values 25*
            # The value in column 2 row 5 is the count of the increasing or decreasing numbers that start with 25
            # (when x = 3, the value in column 2 row 5 is 5 for 255, 256, 257, 258, and 259.)
            # With this concept the values of each matrix as x increases can be found from the previous matrix.
            # NB: These matrices aren't stored to save space, but the calculations below are generated with them in mind.
                partial_sum1 = 9-i
                partial_sum2 = i
                partial_sum3 = 1
                for j in xrange(3,digit+1):
                    partial_sum1 *= (i+j-2) # Calculate sum of upper-right triangle
                    partial_sum1 /= j-2L # Need to divide after multiplication to avoid decimals and rounding errors
                    partial_sum2 *= (10-i+j-3) # Calculate sum of lower-right trianlge, including part of the diagonal
                    partial_sum2 /= j-2L
                    partial_sum3 *= (i+(j-2)) # Calculate the remaining portion of the diagonal NB: This is one higher than it should be, so it is corrected for later
                    partial_sum3 /= j-2L
                sum += partial_sum1 + partial_sum2 + partial_sum3
            sum -= 10 # Adjust for partial_sum3 being one higher than it should for all ten i's
    return sum