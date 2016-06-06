def justify(text, width):
    ''' Takes a string text and an integer width
    Returns a string of text in justified formatting
    '''
    words = text.split()
    final = ""
    lastX = 0
    lineSum = len(words[0])
    for x in range(1,len(words)):
        if len(words[x]) + lineSum + (x-lastX-1) < width:
            lineSum = lineSum + len(words[x])
        else:
            spaces = (width - lineSum)/(max(x - lastX - 1, 1))
            for y in xrange(lastX, x):
                final = final + words[y] + " "*spaces
                if y-lastX < (width - lineSum)%(max(x - lastX - 1,1)):
                    final = final + " "
            final = final.strip() + "\n"
            lastX = x
            lineSum = len(words[x])
    if lastX < len(words):
        spaces = (width - lineSum)/(max(len(words) - 1 - lastX,1))
        for y in xrange(lastX, len(words)):
            final = final + words[y] + " "*spaces
            if y < (width - lineSum)%(max(len(words) - 1 - lastX,1)):
                final = final + " "
    return final[:final.rfind("\n")].strip()+"\n"+" ".join(final[final.rfind("\n"):].split())