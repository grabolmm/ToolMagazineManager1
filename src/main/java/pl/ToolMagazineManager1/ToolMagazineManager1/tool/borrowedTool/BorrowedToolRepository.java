package pl.ToolMagazineManager1.ToolMagazineManager1.tool.borrowedTool;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.ToolMagazineManager1.ToolMagazineManager1.tool.tool.Tool;
import pl.ToolMagazineManager1.ToolMagazineManager1.user.User;

import java.util.List;
import java.util.Optional;

public interface BorrowedToolRepository extends JpaRepository<BorrowedTool, Long> {

    @Query("SELECT e.tool FROM BorrowedTool e WHERE e.user = :user")
    List<Tool> getBorrowedToolsByUserId (@Param("user") Optional<User> user);

    @Query("SELECT e.user FROM BorrowedTool e  WHERE e.tool.id = :toolId")
    List<User> getBorrowedToolsUsersByToolId (@Param("toolId") Long toolId);
}
