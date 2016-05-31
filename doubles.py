def doubles(maxk, maxn):
    ''' Takes two integers maxk and maxn then returns the sum of the following formula for
    all values of k and n.
    The formula is 1/(k*(1+n)^2k).
    '''
    sum = 0.0
    for  k in range(1,maxk+1):
        for n in range(1,maxn+1):
            try: # Values get too small to store
            # Values too small to calculate won't significantly effect sum.
                val = 1/(k*pow(n+1,2.0*k))
            except OverflowError:
                continue
            sum += val
    return sum