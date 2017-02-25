package com.eastiger.samshap.common.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import dagger.releasablereferences.CanReleaseReferences;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@CanReleaseReferences
@Scope
public @interface PerView {
}
