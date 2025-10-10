def solve_sudoku(board):
    """
    board: 9x9 con 0 como vacío
    """
    rows = [0]*9
    cols = [0]*9
    boxes = [0]*9
    empties = []

    def box_id(r, c): return (r//3)*3 + (c//3)
    def bit(d): return 1 << (d-1)

    # Inicializa máscaras
    for r in range(9):
        for c in range(9):
            d = board[r][c]
            if d == 0:
                empties.append((r,c))
            else:
                b = box_id(r,c)
                m = bit(d)
                if rows[r]&m or cols[c]&m or boxes[b]&m:
                    return False  # inválido
                rows[r] |= m
                cols[c] |= m
                boxes[b] |= m

    def backtrack(i=0):
        if i == len(empties):
            return True
        r, c = empties[i]
        b = box_id(r,c)
        mask = rows[r] | cols[c] | boxes[b]
        for d in range(1,10):
            m = bit(d)
            if not (mask & m):
                board[r][c] = d
                rows[r] |= m; cols[c] |= m; boxes[b] |= m
                if backtrack(i+1):
                    return True
                rows[r] ^= m; cols[c] ^= m; boxes[b] ^= m
                board[r][c] = 0
        return False

    return backtrack()

# Ejemplo:
sudoku = [
 [5,3,0, 0,7,0, 0,0,0],
 [6,0,0, 1,9,5, 0,0,0],
 [0,9,8, 0,0,0, 0,6,0],

 [8,0,0, 0,6,0, 0,0,3],
 [4,0,0, 8,0,3, 0,0,1],
 [7,0,0, 0,2,0, 0,0,6],

 [0,6,0, 0,0,0, 2,8,0],
 [0,0,0, 4,1,9, 0,0,5],
 [0,0,0, 0,8,0, 0,7,9]
]
solve_sudoku(sudoku)
sudoku  # resuelto in-place
