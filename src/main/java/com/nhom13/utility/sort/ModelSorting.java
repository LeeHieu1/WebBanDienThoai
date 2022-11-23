package com.nhom13.utility.sort;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;

import com.nhom13.model.Book_;

public class ModelSorting {
    /**
     * Sort by combination of selected attribute <br>
     * <i>Example: sortBy = (1+2+4) = 7 => sort by name, author, price
     * 
     * @param sortBy         null for unsorted and possible value is 1, 2, 4, 8
     * @param sortDescending true if sort in descending order, otherwise ascending
     * @return Sort object <br>
     *         sortBy possible value <br>
     *         &nbsp;&nbsp;&nbsp;&nbsp; 1: by name <br>
     *         &nbsp;&nbsp;&nbsp;&nbsp; 2: by author name <br>
     *         &nbsp;&nbsp;&nbsp;&nbsp; 4: by price <br>
     *         &nbsp;&nbsp;&nbsp;&nbsp; 8: by category <br>
     */
    public static Sort getProductSort(Integer sortBy, Boolean sortDescending) {
        Sort sort = Sort.unsorted();

        if (sortBy != null) {
            if (sortDescending == null || !sortDescending.booleanValue()) { // ASC
                if (sortBy >= 8) {
                    sort = sort.and(JpaSort.of(Book_.category).ascending());
                    sortBy -= 8;
                }
                if (sortBy >= 4) {
                    sort = sort.and(JpaSort.of(Book_.price).ascending());
                    sortBy -= 4;
                }
                if (sortBy >= 2) {
                    sort = sort.and(JpaSort.of(Book_.authorname).ascending());
                    sortBy -= 2;
                }
                if (sortBy >= 1) {
                    sort = sort.and(JpaSort.of(Book_.name).ascending());
                    sortBy -= 1;
                }
            } else { // DESC
                if (sortBy >= 8) {
                    sort = sort.and(JpaSort.of(Book_.category).descending());
                    sortBy -= 8;
                }
                if (sortBy >= 4) {
                    sort = sort.and(JpaSort.of(Book_.price).descending());
                    sortBy -= 4;
                }
                if (sortBy >= 2) {
                    sort = sort.and(JpaSort.of(Book_.authorname).descending());
                    sortBy -= 2;
                }
                if (sortBy >= 1) {
                    sort = sort.and(JpaSort.of(Book_.name).descending());
                    sortBy -= 1;
                }
            }
        }
        return sort;
    }

}
