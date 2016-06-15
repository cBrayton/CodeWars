class Automaton(object):
    '''
    A basic DFA with three states, returns true if the commands leave it in
    state 2. The commands it recognizes are the strings "1" and "0". From state
    1, "0" stays at state 1 and "1" moves to state 2. From state 2, "1" stays at
    state 2 and "0" moves to state 3. From state 3, both "0" and "1" move to
    state 2.
    '''
    def __init__(self):
        self.states = []
        self.states = [True, False, False]

    def read_commands(self, commands):
        # Return True if we end in our accept state, False otherwise
        for statement in commands:
            if(self.states[0] and statement == "1"):
                self.states = [False, True, False]
            elif(self.states[1] and statement == "0"):
                self.states = [False, False, True]
            elif(self.states[2] and (statement == "0" or statement == "1")):
                self.states = [False, True, False]
        return self.states[1]