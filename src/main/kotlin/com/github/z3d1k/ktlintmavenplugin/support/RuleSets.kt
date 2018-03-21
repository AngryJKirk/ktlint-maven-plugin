package com.github.z3d1k.ktlintmavenplugin.support

import com.github.shyiko.ktlint.core.RuleSet
import com.github.shyiko.ktlint.core.RuleSetProvider
import java.util.ServiceLoader

fun resolveRuleSets(
    providers: Iterable<RuleSetProvider> = ServiceLoader.load(RuleSetProvider::class.java)
): List<RuleSet> {
    return providers
            .map { it.get() }
            .sortedWith(compareBy { if (it.id == "standart") 0 else 1 })
}
