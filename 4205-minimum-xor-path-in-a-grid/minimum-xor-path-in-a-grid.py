class Solution:
    def minCost(self, grid: list[list[int]]) -> int:

        m,n = len(grid),len(grid[0])
        possible = [False] * 1024
       
        @cache
        def recursive(i,j,sm):
            if i == m-1 and j == n-1 :
                # mark all possible values at this cell True
                possible[sm ^ grid[i][j]] = True
                return 
            
            # transition to down cell
            if i < m-1:
                recursive(i+1,j,sm^grid[i][j])
            
            # transition to right cell
            if j < n-1:
                recursive(i,j+1,sm^grid[i][j])
            return 
        
        recursive(0,0,0)
        recursive.cache_clear()         # MLE without this method

        for i,n in enumerate(possible):
            if n : return i 