import re

def is_valid_IP(strng):
# Checks a string to see if it is a valid IP address
    address = re.split("\.", strng)
    if len(address) != 4:
        return False
    address = filter(lambda x: x.isdigit(), address)
    address = filter(lambda x: x == x.lstrip('0 '), address)
    address = filter(lambda x: 0 <= int(x) <= 255, address)
    return len(address) == 4