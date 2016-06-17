def triple_double(num1, num2):
    '''
    Returns 1 if a digit in num1 is repeated 3 times in  a row
    and the same digit is repeated twice in a row in num2
    otherwise returns 0
    '''
    last_digit = ""
    run = 0
    for digit in str(num1):
        if last_digit == digit:
            if run == 2 and (last_digit+last_digit) in str(num2):
                return 1
            else:
                run = 2
        last_digit = digit
    return 0