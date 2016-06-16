class Event():
    '''
    A simple event class that lets functions subscribe
    and unsubscribe from the event, and can call all
    subscribed functions with the arguments passed to emit.
    '''
    def __init__(self):
        self.handlers = []
    
    def subscribe(self, handler):
        self.handlers.append(handler)
    
    def unsubscribe(self, handler):
        try:
            self.handlers.remove(handler)
        except:
            print("Handler not subscribed")
    
    def emit(self, *args):
        for handler in self.handlers:
            handler(*args)