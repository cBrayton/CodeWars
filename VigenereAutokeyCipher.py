class VigenereAutokeyCipher:
    '''
    Class that uses a Vigenere Cipher to encode and decode messages
    The class is initilized with a key and an alphabet.
    Any string passed to encode will be encoded using the given key
    with the key extended using the text to be encoded as needed.
    Likewise any string passed to decode will decode the string
    as the reverse of encode.
    '''
    def __init__(self, key, abc):
        self.key = key
        self.abc = abc
        
    def encode(self, text):
        idx = 0
        output = ""
        temp_key = self.key
        while(len(text) > len(temp_key)):
            temp_key = "".join([temp_key,text])
        for letter in text:
            while(self.abc.find(temp_key[idx]) == -1): idx = idx + 1
            if(self.abc.find(letter) > -1):
                output = "".join([output,self.abc[(self.abc.find(letter)+self.abc.find(temp_key[idx]))%len(self.abc)]])
                idx = idx + 1
            else: output = "".join([output,letter])
        return output
        
    def decode(self, text):
        idx = 0
        message = ""
        temp_key = self.key
        for letter in text:
            while(self.abc.find(temp_key[idx]) == -1): idx = idx + 1
            if(self.abc.find(letter) > -1):
                message = "".join([message,self.abc[(self.abc.find(letter)-self.abc.find(temp_key[idx]))%len(self.abc)]])
                if(len(text) > len(temp_key)):
                    temp_key = "".join([temp_key,message[-1]])
                idx = idx + 1
            else: message = "".join([message,letter])
        return message