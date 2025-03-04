import org.scalatest.funsuite.AnyFunSuite
import scala.util.{Success, Failure}
import java.io.File

class ResourceManagementTest extends AnyFunSuite {

  val testFile = "testFile.txt"
  val nonExistentFile = "non_existent.txt"

  test("writeFile should successfully write content to a file") {
    val result = ResourceManagement.writeFile(testFile, "Test Content")
    assert(result.isSuccess)
  }

  test("readFile should successfully read content from an existing file") {
    ResourceManagement.writeFile(testFile, "Test Read Content")
    val result = ResourceManagement.readFile(testFile)
    assert(result == Success("Test Read Content"))
  }

  test("readFile should return Failure for a non-existent file") {
    val result = ResourceManagement.readFile(nonExistentFile)
    assert(result.isFailure)
  }

  test("safeReadFile should return file content when file exists") {
    ResourceManagement.writeFile(testFile, "Safe Read Test")
    val result = ResourceManagement.safeReadFile(testFile)
    assert(result == "Safe Read Test")
  }

  test("safeReadFile should return an error message when file does not exist") {
    val result = ResourceManagement.safeReadFile(nonExistentFile)
    assert(result.startsWith("Error: File"))
  }

  override def afterAll(): Unit = {
    new File(testFile).delete() // Cleanup test file after execution
  }
}
