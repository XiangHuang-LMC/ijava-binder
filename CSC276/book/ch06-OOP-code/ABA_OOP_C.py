#ABA_OOP_C.py: very simple object-oriented design example.
# Entry and non-persistent storage of name, no duplicate names,
# a phone number and email(better).

def addressBook():
    aba = ABA_OOP_C()
    aba.go()

class ABA_OOP_C:
    def __init__(self):
        self.book = {}

    def go(self):
        name = self.getTextLine("Enter contact name ('exit' to quit): ")
        while name != "exit":
            phone = self.getTextLine("Enter phone number for " + name + ": ")
            email = self.getTextLine("Enter email address for " + name + ": ")
            if name not in self.book:
                self.book[name] = (phone, email)
            name = self.getTextLine("Enter contact name ('exit' to quit): ")

        self.displayBook()

    def getTextLine(self, prompt):
        return input(prompt)

    def displayBook(self):
        print()
        print("TEST: Display contents of address book")
        print("TEST: The address book contains the following contacts")
        sortedNames = sorted(self.book.keys())
        for name in sortedNames:
            print(name, self.book[name])
