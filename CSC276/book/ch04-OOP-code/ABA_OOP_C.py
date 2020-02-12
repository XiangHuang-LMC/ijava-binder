#ABA_OOP_C.py: very simple object-oriented design example.
# Entry and non-persistent storage of name, no duplicate names (sequential search).

def addressBook():
    aba = ABA_03c()
    aba.go()

class ABA_OOP_C:
    def go(self):
        self.book = []
        name = self.getName()
        while name != "exit":
            if name not in self.book:
                self.book.append(name)
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
