#ABA_OOP_A.py: very simple object-oriented design example.
# Entry and non-persistent storage of name, no duplicate names (dictionary).

def addressBook():
    aba = ABA_OOP_A()
    aba.go()

class ABA_OOP_A:
    def go(self):
        self.book = {}
        name = self.getName()
        while name != "exit":
            if name not in self.book:
                self.book[name] = None
            name = self.getName()

        self.displayBook()

    def getName(self):
        return input("Enter contact name ('exit' to quit): ")

    def displayBook(self):
        print()
        print("TEST: Display contents of address book")
        print("TEST: The address book contains the following contacts")
        for name in self.book:
            print(name)
