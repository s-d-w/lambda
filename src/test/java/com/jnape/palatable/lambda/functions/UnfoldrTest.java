package com.jnape.palatable.lambda.functions;

import com.jnape.palatable.lambda.MonadicFunction;
import com.jnape.palatable.traitor.annotations.TestTraits;
import com.jnape.palatable.traitor.runners.Traits;
import org.junit.Test;
import org.junit.runner.RunWith;
import testsupport.traits.ImmutableIteration;
import testsupport.traits.InfiniteIteration;
import testsupport.traits.Laziness;

import java.util.ArrayList;

import static com.jnape.palatable.lambda.builtin.monadic.Always.always;
import static com.jnape.palatable.lambda.functions.Take.take;
import static com.jnape.palatable.lambda.functions.Unfoldr.unfoldr;
import static org.junit.Assert.assertThat;
import static testsupport.matchers.IterableMatcher.iterates;

@RunWith(Traits.class)
public class UnfoldrTest {

    @TestTraits({Laziness.class, InfiniteIteration.class, ImmutableIteration.class})
    public MonadicFunction<? extends Iterable, ? extends Iterable> createTestSubject() {
        return unfoldr(always(new ArrayList<String>()));
    }

    @Test
    public void unfoldsIterableFromSeedValueAndSuccessiveFunctionApplications() {
        MonadicFunction<Integer, Integer> add1 = new MonadicFunction<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 1;
            }
        };
        assertThat(take(5, unfoldr(add1, 0)), iterates(0, 1, 2, 3, 4));
    }
}
