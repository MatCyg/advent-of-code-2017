fun String.resourceAsText() = Thread.currentThread().contextClassLoader.getResource(this).readText()
