package com.persons.finder.data.repository

import com.persons.finder.data.entity.Location
import org.springframework.data.jpa.repository.JpaRepository

interface LocationRepository : JpaRepository<Location, Long>