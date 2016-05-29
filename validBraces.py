def validBraces(string):
    '''Takes a string containing braces, brackets, and parentheses
       Returns True if the pattern of braces is valid otherwise returns False'''
    stack = []
    for s in string:
        if s == "(" or s == "[" or s == "{":
            stack.append(s)
        else:
            if len(stack) == 0: return False
            val = stack.pop()
            if s == ")" and val != "(": return False
            elif s == "]" and val != "[": return False
            elif s == "}" and val != "{": return False            
    return len(stack) == 0