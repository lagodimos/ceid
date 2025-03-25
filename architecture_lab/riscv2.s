# Άσκηση 5

# Αρχικοποίηση των x3, x4
lui x3, 0x00678
lui x4, 0xFF767

# Αν x4 < 0 ( msb(x4)=1 ) τότε τερμάτισε
# (x4 > x3 αφού x4 είναι απρόσημος)
addi x5, zero, 1
blt x4, zero, endif

# Αλλιώς μπορόυμε να συγκρίνουμε
# τους x3/x4 ως προσημασμένους
slt x5, x4, x3  # x5 = (x4 < x3)
addi x6, zero, 1
xor x5, x5, x6  # x5 = !x5

endif:

# Άσκηση 6

addi x10, zero, 0x100    # Αρχική διεύθυνση

addi x1, zero, 1
addi x2, zero, 2
addi x3, zero, 3
addi x4, zero, 4
addi x5, zero, 5
addi x6, zero, 6
addi x7, zero, 7

# (0x100 + 3) % 8
# = (256 + 3) % 8
# = 3 % 8
# = 3

sb x3, 0(x10)
sb x4, 1(x10)
sb x5, 2(x10)
sb x6, 3(x10)
sb x7, 4(x10)
sb x0, 5(x10)
sb x1, 6(x10)
sb x2, 7(x10)
sb x3, 8(x10)
sb x4, 9(x10)
sb x5, 10(x10)
sb x6, 11(x10)
sb x7, 12(x10)
sb x0, 13(x10)
sb x1, 14(x10)
sb x2, 15(x10)

# Άσκηση 7
lui x5, 0xAF
addi x5, x5, 0x586

lui x6, 0x2
addi x6, x6, 0x345

lui x7, 0xEF1
addi x7, x7, 0x934

lui x8, 0x5
addi x8, x8, 0x672

lui x9, 0x98
addi x9, x9, 0x4FA

lui x10, 0x56
addi x10, x10, 0x440

lui x11, 0x23B
addi x11, x11, 0xEBC

# a

lui x3, 0x2         # Φόρτωσε τη διεύθυνση 0x2000

sw x5, 0x0(x3)
sw x6, 0x4(x3)
sw x7, 0x8(x3)
sw x8, 0xC(x3)
sw x9, 0x10(x3)
sw x10, 0x14(x3)
sw x11, 0x18(x3)

# b

# x2:λέξη
# x3: διεύθυνση για φόρτωση
# x4: διεύθυνση για αποθήκευση

# x15: διεύθυνση τελευταίας λέξης + 4
lui x15, 0x2
addi x15, x15, 0x1C

### Πίνακας Β (300) : Υπόλοιπο

addi x14, zero, 0xF     # Μάσκα για τα 4 LSBs
addi x4, zero, 0x12C    # Φόρτωσε τη διεύθυνση 300 στον x2

loop1:
beq x3, x15, quotient
lw x2, 0(x3)
and x2, x2, x14    # Κράτησε μόνο τα 4 LSBs
sw x2, 0(x4)

# Ενημέρωση διευθύνσεων
addi x3, x3, 4
addi x4, x4, 4

beq zero, zero, loop1

quotient:
### Πίνακας Γ (400) :Πυλίκο

lui x3, 0x2
addi x4, zero, 0x190    # Φόρτωσε τη διεύθυνση 300 στον x2

loop2:
beq x3, x15, end
lw x2, 0(x3)
srli x2, x2, 4      # Αν προσημασμέμοι: sra
sw x2, 0(x4)

# Ενημέρωση διευθύνσεων
addi x3, x3, 4
addi x4, x4, 4

beq zero, zero, loop2

end:
