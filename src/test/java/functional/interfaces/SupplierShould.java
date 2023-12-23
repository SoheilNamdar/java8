package functional.interfaces;

import football.playes.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class SupplierShould {
    @Test
    void have_any_entry_and_return_a_type() {
        Supplier<Player> soheil = () -> new Player("soheil", 98);
        String name = soheil.get().getName();
        assertThat(name).isEqualTo("soheil");
        int goal = soheil.get().getGoal();
        assertThat(goal).isEqualTo(98);

        int var = -1;
        IntSupplier abs = () -> Math.abs(var);
        int asInt = abs.getAsInt();
        Assertions.assertThat(asInt).isEqualTo(1);
    }
}
