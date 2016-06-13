values = {(0,0): 1}
def exp_sum(n, m=None):
    '''
    Calculates the number of partitions of a number n.
    Uses the recursive formula p(n,m) = sum(p(n-k,k), for k = 1 to m)
    Stores all calculated values in a dictionary, which consumes space,
    but makes subsequent tests faster.
    '''
    if(m == None): m = n
    if(n < 0 or m < 0): return 0
    if(n == 0): return values[(0,0)]
    if((n,m) in values): return values[(n,m)]
    else:
        values[(n,m)] = sum(map(exp_sum,range(n-1,n-m-1,-1),range(1,m+1)))
    return values[(n,m)]