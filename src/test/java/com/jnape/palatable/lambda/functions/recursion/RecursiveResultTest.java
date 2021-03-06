package com.jnape.palatable.lambda.functions.recursion;

import com.jnape.palatable.traitor.annotations.TestTraits;
import com.jnape.palatable.traitor.framework.Subjects;
import com.jnape.palatable.traitor.runners.Traits;
import org.junit.runner.RunWith;
import testsupport.traits.ApplicativeLaws;
import testsupport.traits.FunctorLaws;
import testsupport.traits.MonadLaws;
import testsupport.traits.TraversableLaws;

import static com.jnape.palatable.lambda.functions.recursion.RecursiveResult.recurse;
import static com.jnape.palatable.lambda.functions.recursion.RecursiveResult.terminate;
import static com.jnape.palatable.traitor.framework.Subjects.subjects;

@RunWith(Traits.class)
public class RecursiveResultTest {

    @TestTraits({FunctorLaws.class, ApplicativeLaws.class, MonadLaws.class, TraversableLaws.class})
    public Subjects<RecursiveResult<String, Integer>> testSubject() {
        return subjects(recurse("foo"), terminate(1));
    }
}