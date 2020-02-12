#ABA_OPP_A.py: very simple object-oriented design example.
# Validation of name and phone number, in non-persistent storage.

import re   #regular expression library

def addressBook():
    aba = ABA_OOP_A()
    aba.go()

class ABA_OOP_A:
    def __init__(self):
        self.book = {}

    def go(self):
        name = self.getValidName()
        while name != "exit":
            phone = self.getValidPhone(name)
            email = self.getTextLine("Enter email address for " + name + ": ")
            if name not in self.book:
                self.book[name] = (phone, email)
            name = self.getValidName()

        self.displayBook()

    #pre: prompt contains a message (typically instructions) to be displayed to user.
    #post: returns value entered by user as a string.
    def getTextLine(self, prompt):
        return input(prompt)

    #pre: Need to obtain a contact name from the user.
    #post: A valid contact name is returned.
    def getValidName(self):
        #A valid contact name may contain only spaces, uppercase letters, and lowercase letters.
        pattern = "^[ A-Za-z]+$"
        result = None
        #Continue asking for a contact name until valid data is entered.
        while result == None:
            name = self.getTextLine("Enter contact name ('exit' to quit): ")
            #Remove leading and trailing whitespace.
            name = name.strip()
            if len(name) == 0:
                #contact name must contain at least one letter.
                result = None
                errorMsg = "A contact name must contain at least one uppercase or lowercase letters."
            else:
                #Determine if the entered name is valid.
                result = re.match(pattern, name)
                errorMsg = "A contact name must contain only uppercase and lowercase letters and spaces."
            if result == None:
                print(errorMsg)

        return name

    #pre: Need to obtain a phone number from the user.
    #post: A valid phone number is returned.
    def getValidPhone(self, name):
        #A valid phone number must contain one or more digits.
        pattern = "^[0-9]+$"
        result = None
        #Continue asking for a phone number until valid data is entered.
        while result == None:
            phone = self.getTextLine("Enter phone number for " + name + ": ")
            #Remove leading and trailing whitespace.
            phone = phone.strip()
            #Determine if the entered name is valid.
            result = re.match(pattern, phone)
            if result == None:
                print("A phone number must contain one or more digits.")

        return phone

    def displayBook(self):
        print()
        print("TEST: Display contents of address book")
        print("TEST: The address book contains the following contacts")
        sortedNames = sorted(self.book.keys())
        for name in sortedNames:
            print(name, self.book[name])
