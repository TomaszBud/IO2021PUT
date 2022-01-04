package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {

    @Test
    void loadExpenses() {

        IFancyDatabase mocked = mock(MyDatabase.class);
        InOrder inOrder = inOrder(mocked);
        ExpenseRepository expenseRepository = new ExpenseRepository(mocked);
        expenseRepository.loadExpenses();
        assertEquals( Collections.emptyList(), expenseRepository.getExpenses());

        inOrder.verify(mocked, atLeastOnce()).connect();
        inOrder.verify(mocked, atLeastOnce()).queryAll();
        inOrder.verify(mocked, atLeastOnce()).close();

    }

    @Test
    void saveExpenses(){
        IFancyDatabase mocked = mock(MyDatabase.class);
        InOrder inOrder = inOrder(mocked);
        ExpenseRepository expenseRepository = new ExpenseRepository(mocked);
        expenseRepository.saveExpenses();
        assertEquals( Collections.emptyList(), expenseRepository.getExpenses());

        inOrder.verify(mocked, atLeastOnce()).connect();
        inOrder.verify(mocked, atLeastOnce()).queryAll();
        inOrder.verify(mocked, atLeastOnce()).close();

    }
}
