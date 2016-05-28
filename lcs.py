def lcs(x, y):
  '''Takes two strings and returns a string of the longest 
      common subsequence between them'''
  if x == "" or y == "":
      return ""
  if x == y:
      return x
  if x[-1] == y[-1]:
      return lcs(x[:-1],y[:-1])+x[-1]
  else:
      xs = lcs(x[:-1],y)
      ys = lcs(x,y[:-1])
      if len(xs) > len(ys):
          return xs
      else: return ys